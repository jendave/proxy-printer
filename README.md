proxy-printer
=============

Prints out quick-and-dirty proxies for a popular trading card game

## DESCRIPTION:

This application will print out quick-and-dirty proxies for a popular trading card game.
The images are simply linked from magiccards.info.

## INSTALLATION:

To install it simply unzip the zip file into a directory in your path.
You will see four files.

    proxy-printer
    proxy-printer.bat
    proxy-printer-<version>-full.jar
    proxy-printer.properties

## CONFIGURATION:

Run proxy-printer with the following syntax:

    proxy-printer <flags> <filename.dec>

For example, to convert the sample.dec file into a HTML page you run:

    proxy-printer sample.dec
This will output a `sample.html` file.

proxy-printer takes one command line flag

    --skip-basic            Skips printing Basic Lands

To print everything except the basic lands run:

    proxy-printer --skip-basic sample.dec

You can also set some properties in the `proxy-printer.properties` file

    config.cardBorder=0
    config.cardHeight=319
    config.cardWidth=222
    config.skipBasicLands=true

## LICENSE:

Author: David Hudson <jendave@yahoo.com>

Copyright: Copyright (c) 2012 David Hudson.

License: GPL License, Version 3

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.


## How to Contribute

Send pull request to <https://github.com/jendave/proxy-printer>.
