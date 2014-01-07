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
public class Token {

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return this.url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String url;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***** Token Details *****\n");
        sb.append("Name="+getName()+"\n");
        sb.append("Url="+getUrl()+"\n");
        sb.append("*****************************");

        return sb.toString();
    }
}
