/*
 * Copyright (C) 2012  David Hudson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.londonsburning.proxy;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Generates the HTML for the proxies.
 */
public class ProxyPrinter {

    /**
     *
     */
    private ProxyConfiguration proxyConfiguration;

    /**
     *
     */
    private final Logger logger = LoggerFactory
            .getLogger(ProxyPrinterRunner.class);

    /**
     *
     */
    private String proxyBackUrl =
            "https://raw.github.com/jendave/proxy-printer"
                    + "/master/token-images/mtg-card-back.jpg";

    /**
     * @param proxyConfigurationParam ProxyConfiguration
     */
    public ProxyPrinter(final ProxyConfiguration proxyConfigurationParam) {
        this.proxyConfiguration = proxyConfigurationParam;
    }

    /**
     * <p>
     * writeDeck.
     * </p>
     *
     * @param deck           a String
     * @param file           a File
     * @param skipBasicLands Skip Basic Lands
     */
    private void generateHtml(final Deck deck, final File file,
                              final boolean skipBasicLands) {
        try {
            final BufferedWriter htmlOutput =
                    new BufferedWriter(new FileWriter(file));

            Template template;

            final Configuration cfg = new Configuration();
            cfg.setClassForTemplateLoading(deck.getClass(), "/");
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            template = cfg.getTemplate(this.proxyConfiguration
                    .getOutputTemplate());

            final TreeMap<String, Object> root = new TreeMap<String, Object>();
            root.put("title", deck.getDeckName());
            final List<String> list = new ArrayList<String>();
            for (final String cardName : deck.getCardList().keySet()) {
                for (int i = 0; i <= (deck.getCardList().get(cardName) - 1);
                     i++) {
                    if (!this.proxyConfiguration
                            .getBasicLandNames()
                            .contains(cardName) || !skipBasicLands) {
                        list.add(getURL(cardName));
                    }
                }
            }

            final LinkedHashMap<String, Integer> map =
                    deck.getCardList();
            root.put("urls", list);
            root.put("cardBorder",
                    this.proxyConfiguration.getCard().getCardBorder());
            root.put("cardHeight", Math.round(
                    this.proxyConfiguration.getCard().getCardHeight()
                            * this.proxyConfiguration
                                    .getCard()
                                    .getCardScale()));
            root.put("cardWidth", Math.round(
                    this.proxyConfiguration
                            .getCard()
                            .getCardWidth()
                            * this.proxyConfiguration
                            .getCard()
                            .getCardScale()));
            root.put("cardListWidth",
                    this.proxyConfiguration.getCard().getCardWidth()
                            - this.proxyConfiguration.getCardListWidth());
            root.put("cardList", map);
            root.put("numberOfCards", deck.getNumberOfCards());

            /* Merge data-model with template */
            template.process(root, htmlOutput);
            htmlOutput.flush();
            htmlOutput.close();
        } catch (final IOException e) {
            logger.debug(e.toString());
        } catch (final TemplateException e) {
            logger.debug(e.toString());
        } catch (final URISyntaxException e) {
            logger.debug(e.toString());
        } catch (final InterruptedException e) {
            logger.debug(e.toString());
        }
    }

    /**
     * @param cardName Name of Card
     * @return String Url
     * @throws URISyntaxException   Exception
     * @throws IOException          Exception
     * @throws InterruptedException Exception
     */
    private String getURL(final String cardName) throws
            URISyntaxException,
            IOException,
            InterruptedException {
        URI uri = new URI(
                "http",
                "magiccards.info",
                "/query",
                "q=!" + cardName,
                null);
        String request = uri.toString();

        URL url = new URL(request);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        Thread.sleep(1000);
        while (bufferedReader.ready()) {
            String lineHtml = bufferedReader.readLine();
            Thread.sleep(1);
//            System.out.println("URL: " + lineHtml);
            if (lineHtml.contains("http://magiccards.info/scans/en")
                    && lineHtml.contains("jpg")) {
                return lineHtml.substring(lineHtml.indexOf("http"),
                        lineHtml.indexOf("jpg") + ".jpg".length() - 1);

                //return lineHtml;
            }
        }
        String tokenUrl = parseTokens(cardName);
        if (tokenUrl.isEmpty()) {
            return proxyBackUrl;
        } else {
            return tokenUrl;
        }
    }

    /**
     *
     * @param cardName  cardName
     * @return  Url
     * @throws IOException Exception
     */
    public final String parseTokens(final String cardName) throws IOException {
        InputStream is;
        String url = "";
        is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("tokens.json");
        JsonParser jsonParser = new JsonFactory().createParser(is);
        Iterator<Token> it = new ObjectMapper()
                .readValues(jsonParser, Token.class);
        try {
            while (it.hasNext()) {
                Token token = it.next();
                if (token.getName().equalsIgnoreCase(cardName)) {
                    url = token.getUrl();
                }
            }
        } finally {
            is.close();
        }
        return url;
    }

    /**
     * @param flagParserParam flagParser
     */
    public final void printProxies(final FlagParser flagParserParam) {
        for (String arg : flagParserParam.getFlags()) {
            if (!arg.contentEquals(flagParserParam.getSkipBasicLandsFlag())) {
                File file = new File(arg);
                Deck deck = new Deck(file);
                deck.parse();
                File htmlFile = new File(arg.replace(".dec", ".html"));
                generateHtml(deck, htmlFile, flagParserParam
                        .isSkipBasicLands());
                logger.info("Output file: " + htmlFile.getName());
            }
        }
    }
}
