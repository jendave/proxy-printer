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
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Card {
    /**
     * @param cardBorder          int
     * @param cardHeight          int
     * @param cardWidth           int
     * @param cardScale           int
     */
    public Card(final int cardBorder,
                final int cardHeight,
                final int cardWidth,
                final float cardScale
    ) {
        this.cardBorder0 = cardBorder;
        this.cardHeight0 = cardHeight;
        this.cardWidth0 = cardWidth;
        this.cardScale0 = cardScale;
    }

    /**
     *
     */
    private int cardHeight0;

    /**
     *
     */
    private int cardWidth0;

    /**
     *
     */
    private int cardBorder0;

    /**
     * @return int scale of card
     */
    public final float getCardScale() {
        return cardScale0;
    }

    /**
     * @param cardScale float scale the card
     */
    public final void setCardScale(final float cardScale) {
        this.cardScale0 = cardScale;
    }

    /**
     *
     */
    private float cardScale0;

    /**
     * @return int card height
     */
    public final int getCardHeight() {
        return cardHeight0;
    }

    /**
     * @param cardHeight card height
     */
    public final void setCardHeight(final int cardHeight) {
        this.cardHeight0 = cardHeight;
    }

    /**
     * @return int card width
     */
    public final int getCardWidth() {
        return cardWidth0;
    }

    /**
     * @param cardWidth width of card
     */
    public final void setCardWidth(final int cardWidth) {
        this.cardWidth0 = cardWidth;
    }

    /**
     * @return int card border
     */
    public final int getCardBorder() {
        return cardBorder0;
    }

    /**
     * @param cardBorderParam card border size
     */
    public final void setCardBorder(final int cardBorderParam) {
        this.cardBorder0 = cardBorderParam;
    }
}
