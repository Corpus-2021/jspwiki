/* 
    JSPWiki - a JSP-based WikiWiki clone.

    Copyright (C) 2001-2002 Janne Jalkanen (Janne.Jalkanen@iki.fi)

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.ecyrd.jspwiki;

/**
 *  Marks an erroneus jspwiki.properties file.  Certain properties
 *  have been marked as "required", and if you do not provide
 *  a good value for a property, you'll see this exception.
 *  <P>
 *  Check <TT>jspwiki.properties</TT> for the required properties.
 *
 *  @author Janne Jalkanen
 */
public class NoRequiredPropertyException
    extends WikiException
{
    /**
     *  Constructs an exception.
     *
     *  @param msg Message to show
     *  @param key The key of the property in question.
     */
    public NoRequiredPropertyException( String msg, String key )
    {
        super(msg+": key="+key);
    }
}
