proxy-printer
=============

Prints out quick-and-dirty proxies for the Magic: The Gathering trading card game

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

    card.cardBorder=0
    card.cardHeight=319
    card.cardWidth=222
    card.cardScale=0.9
    config.skipBasicLands=true

## STATUS
[![Build Status](https://travis-ci.org/jendave/proxy-printer.png?branch=master)](https://travis-ci.org/jendave/proxy-printer)

## TODO
Print out command line options help.

## CONTRIBUTE

proxy-printer is written in Java using JDK 1.7

Send a pull request to <https://github.com/jendave/proxy-printer>.

Maven site development documentation:
<http://jendave.github.com/proxy-printer>

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

## CREDITS
### Website Links
http://www.mtgsalvation.com/forums/magic-fundamentals/magic-general/330492-the-great-creature-token-project
http://www.mtgsalvation.com/forums/creativity/artwork/340749-official-custom-tokens-token-collection-thread
### Token Images
David Clarke - http://xandor.ca/tokens/

Dragon Spirit
Urami
Voja
Centaur
Knight
Faerie

StClaus @ MTGSalvation.com - http://www.mtgsalvation.com/forums/creativity/artwork/340749-official-custom-tokens-token-collection-thread?page=17#c423
Ape
Assembly-Worker
Bat
Beast
Bird
Camarid
Cat Warrior
Centau
Citizen
Drake
Elemental
Giant
Goblin - Haste
Graveborn
Horror
Insect - Shroud
Karldra
Knight - B
Kobolds
Marit Lage
Pest
Pincher
Sand
Serf
Sheep
Snake
Spawn
Spirit - Colorless
Thrull
Triskelavite
Twin
Weird
Wirefly
Wolf - Sound the Call
Wurm

Dr. Shades @ MTGSalvation - http://www.mtgsalvation.com/forums/magic-fundamentals/magic-general/330492-the-great-creature-token-project
A huge amount of tokens

Missing:
1/1 Green Ape (Uktabi Kong)
Bird 4/4 Red (Rukh Egg)
Cat Warrior 3/3 (Nactl War-Pride)
X/X Green Elephant (Elephant Resurgence)
1/1 Colorless Expansion-Symbol (Symbol Status)
5/5 Green Beast--Trample (Spawning Grounds)
?/? ? Artifact, ? (Mirrorworks)
?/? ? ?--? "This creature is a Spirit in addition to its other types." (Séance)
?/? ? ?--? "At the beginning of your upkeep, if this creature isn't a token, put a token onto the battlefield that's a copy of this creature." (Progenitor Mimic)
?/? ? ?--? (Back from the Brink) 
1/1 Red Human--Haste (Thatcher Revolt)
7/7 Green Insect named "Giant Adephage"--Trample, "Whenever Giant Adephage deals combat damage to a player, put a token onto the battlefield that's a copy of Giant Adephage." (Giant Adephage)
1/1 Colorless artifact creature, Myr named "Myr Propagator"--"3, t: Put a token that's a copy of Myr Propagator onto the battlefield." (Myr Propagator)
0/2 Green Plant Hydra--Defender, "Whenever this creature is dealt damage, you may put a creature token in play that's a copy of this creature." (Sprouting Phytohydra)
*/* Black Rat named "Pack Rat"--"Pack Rat's power and toughness are each equal to the number of Rats you control. 2B, Discard a card: Put a token onto the battlefield that's a copy of Pack Rat." (Pack Rat)
4/4 White Rhino Soldier named "Mirror-Sigil Sergeant"--Trample, "At the beginning of your upkeep, if you control a blue permanent, you may put a token into play that's a copy of Mirror-Sigil Sergeant." (Mirror-Sigil Sergeant)
*/* Black Shadow (Broken Visage)
1/1 Red Soldier--Haste (Akroan Crusader) 



