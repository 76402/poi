/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.sl.usermodel;

import java.awt.Color;

import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.draw.geom.IAdjustableShape;


public interface SimpleShape<
    S extends Shape<S,P>,
    P extends TextParagraph<S,P,?>
> extends Shape<S,P>, IAdjustableShape, PlaceableShape<S,P> {

    enum Placeholder {
        TITLE,
        BODY,
        CENTERED_TITLE,
        SUBTITLE,
        DATETIME,
        SLIDE_NUMBER,
        FOOTER,
        HEADER,
        CONTENT,
        CHART,
        TABLE,
        CLIP_ART,
        DGM,
        MEDIA,
        SLIDE_IMAGE,
        PICTURE
    }
    
    FillStyle getFillStyle();
    
    LineDecoration getLineDecoration();
    
    StrokeStyle getStrokeStyle();
    
    /**
     * Sets the line attributes.
     * Possible attributes are Double (width), LineCap, LineDash, LineCompound, Color
     * (implementations of PaintStyle aren't yet supported ...)
     * 
     * If no styles are given, the line will be hidden
     *
     * @param styles the line attributes
     */
    void setStrokeStyle(Object... styles);

    CustomGeometry getGeometry();

    ShapeType getShapeType();
    void setShapeType(ShapeType type);

    boolean isPlaceholder();

	Shadow<S,P> getShadow();

    /**
     * Returns the solid color fill.
     *
     * @return solid fill color of null if not set or fill color
     * is not solid (pattern or gradient)
     */
	Color getFillColor();

    /**
     * Specifies a solid color fill. The shape is filled entirely with the
     * specified color.
     *
     * @param color the solid color fill. The value of <code>null</code> unsets
     *              the solid fill attribute from the underlying implementation
     */
	void setFillColor(Color color);
}
