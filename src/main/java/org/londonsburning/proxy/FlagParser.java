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

/**
 * Created with IntelliJ IDEA.
 * User: dhudson
 * Date: 10/15/12
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlagParser {

    /**
     * @param skipBasicLandsFlagParam skip printing of basic lands
     */
    public FlagParser(final String skipBasicLandsFlagParam) {
        this.skipBasicLandsFlag0 = skipBasicLandsFlagParam;
    }

    /**
     *
     */
    //private final Logger logger = LoggerFactory
    //            .getLogger(FlagParser.class);

    /**
     * @return String[] flags
     */
    public final String[] getFlags() {
        return flags0;
    }

    /**
     * @param flags flags
     */
    public final void setFlags(final String[] flags) {
        this.flags0 = flags;
    }

    /**
     *
     */
    private String[] flags0;

    /**
     *
     */
    private String skipBasicLandsFlag0;

    /**
     * @return String skipBasicLandsFlag
     */
    public final String getSkipBasicLandsFlag() {
        return skipBasicLandsFlag0;
    }

    /**
     * @param skipBasicLandsFlag skip basic lands
     */
    public final void setSkipBasicLandsFlag(final String skipBasicLandsFlag) {
        this.skipBasicLandsFlag0 = skipBasicLandsFlag;
    }

    /**
     * @return boolean skip basic lands
     */
    public final boolean isSkipBasicLands() {
        return skipBasicLands0;
    }

    /**
     * @param skipBasicLands  Skip basic lands
     */
    public final void setSkipBasicLands(final boolean skipBasicLands) {
        this.skipBasicLands0 = skipBasicLands;
    }

    /**
     *
     */
    private boolean skipBasicLands0;

    /**
     * Parse flags.
     */
    public final void parse() {
        for (String arg : this.flags0) {
            if (arg.contentEquals(this.getSkipBasicLandsFlag())) {
                this.skipBasicLands0 = true;
                break;
            }
        }
    }
}
