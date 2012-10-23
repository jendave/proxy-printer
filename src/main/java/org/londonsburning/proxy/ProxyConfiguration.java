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

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: dhudson
 * Date: 10/15/12
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProxyConfiguration {
    /**
     * @param cardParam           Card
     * @param cardListWidthParam  int
     * @param outputTemplateParam String
     * @param basicLandNamesParam Strings
     * @param flagParserParam     Flag Parser
     */
    public ProxyConfiguration(final Card cardParam,
                              final int cardListWidthParam,
                              final String outputTemplateParam,
                              final HashSet<String> basicLandNamesParam,
                              final FlagParser flagParserParam
    ) {
        this.card0 = cardParam;
        this.outputTemplate0 = outputTemplateParam;
        this.cardListWidth0 = cardListWidthParam;
        this.basicLandNames0 = basicLandNamesParam;
        this.flagParser0 = flagParserParam;
    }

    /**
     *
     */
    private Card card0;

    /**
     *
     * @return int Card List Width
     */
    public final int getCardListWidth() {
        return cardListWidth0;
    }

    /**
     *
     * @param cardListWidth int
     */
    public final void setCardListWidth(final int cardListWidth) {
        this.cardListWidth0 = cardListWidth;
    }

    /**
     *
     */
    private int cardListWidth0;

    /**
     *
     */
    private HashSet<String> basicLandNames0 = new HashSet<String>();

    /**
     *
     */
    private String outputTemplate0 = "";

    /**
     * @return FlagParser
     */
    public final FlagParser getFlagParser() {
        return this.flagParser0;
    }

    /**
     * @param flagParser flag parser
     */
    public final void setFlagParser(final FlagParser flagParser) {
        this.flagParser0 = flagParser;
    }

    /**
     * @param skipBasicLands Skip basic lands
     */
    public final void setSkipBasicLands(final boolean skipBasicLands) {
        this.flagParser0.setSkipBasicLands(skipBasicLands);
    }

    /**
     *
     */
    private FlagParser flagParser0;


    /**
     * @return int card border
     */
    public final Card getCard() {
        return card0;
    }

    /**
     * @param cardParam card border size
     */
    public final void setCard(final Card cardParam) {
        this.card0 = cardParam;
    }

    /**
     * @return HashSet<String> Basic land names
     */
    public final HashSet<String> getBasicLandNames() {
        return basicLandNames0;
    }

    /**
     * @param basicLandNames basic land names
     */
    public final void setBasicLandNames(final HashSet<String> basicLandNames) {
        this.basicLandNames0 = basicLandNames;
    }

    /**
     * @return String output template
     */
    public final String getOutputTemplate() {
        return outputTemplate0;
    }

    /**
     * @param outputTemplate output template
     */
    public final void setOutputTemplate(final String outputTemplate) {
        this.outputTemplate0 = outputTemplate;
    }
}
