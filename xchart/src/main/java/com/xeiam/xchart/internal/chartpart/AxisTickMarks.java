/**
 * Copyright 2011-2013 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xeiam.xchart.internal.chartpart;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Axis tick marks. This includes the little tick marks and the line that hugs the plot area.
 */
public class AxisTickMarks implements ChartPart {

  /** parent */
  private AxisTick axisTick;

  /** the bounds */
  private Rectangle2D bounds = new Rectangle2D.Double();

  /**
   * Constructor
   * 
   * @param axisTick
   */
  protected AxisTickMarks(AxisTick axisTick) {

    this.axisTick = axisTick;
  }

  @Override
  public Rectangle2D getBounds() {

    return bounds;
  }

  @Override
  public void paint(Graphics2D g) {

    g.setColor(getChartPainter().getStyleManager().getAxisTickMarksColor());
    g.setStroke(getChartPainter().getStyleManager().getAxisTickMarksStroke());

    if (axisTick.getAxis().getDirection() == Axis.Direction.Y && getChartPainter().getStyleManager().isYAxisTicksVisible()) { // Y-Axis

      double xOffset = axisTick.getAxisTickLabels().getBounds().getX() + axisTick.getAxisTickLabels().getBounds().getWidth() + getChartPainter().getStyleManager().getAxisTickPadding();
      double yOffset = axisTick.getAxis().getPaintZone().getY();

      // tick marks
      if (getChartPainter().getStyleManager().isAxisTicksMarksVisible()) {

        for (int i = 0; i < axisTick.getTickLabels().size(); i++) {

          int tickLocation = axisTick.getTickLocations().get(i);

          Shape line =
              new Line2D.Double(xOffset, yOffset + axisTick.getAxis().getPaintZone().getHeight() - tickLocation, xOffset + getChartPainter().getStyleManager().getAxisTickMarkLength(), yOffset
                  + axisTick.getAxis().getPaintZone().getHeight() - tickLocation);
          g.draw(line);

        }
      }
      // Line
      if (getChartPainter().getStyleManager().isAxisTicksLineVisible()) {

        Shape line =
            new Line2D.Double(xOffset + getChartPainter().getStyleManager().getAxisTickMarkLength(), yOffset, xOffset + getChartPainter().getStyleManager().getAxisTickMarkLength(), yOffset
                + axisTick.getAxis().getPaintZone().getHeight());
        g.draw(line);

      }

      // bounds
      bounds = new Rectangle2D.Double(xOffset, yOffset, getChartPainter().getStyleManager().getAxisTickMarkLength(), axisTick.getAxis().getPaintZone().getHeight());
      // g.setColor(Color.yellow);
      // g.draw(bounds);

    }
    else if (axisTick.getAxis().getDirection() == Axis.Direction.X && getChartPainter().getStyleManager().isXAxisTicksVisible()) { // X-Axis

      double xOffset = axisTick.getAxis().getPaintZone().getX();
      double yOffset = axisTick.getAxisTickLabels().getBounds().getY() - getChartPainter().getStyleManager().getAxisTickPadding();

      // tick marks
      if (getChartPainter().getStyleManager().isAxisTicksMarksVisible()) {

        for (int i = 0; i < axisTick.getTickLabels().size(); i++) {

          int tickLocation = axisTick.getTickLocations().get(i);

          Shape line = new Line2D.Double(xOffset + tickLocation, yOffset, xOffset + tickLocation, yOffset - getChartPainter().getStyleManager().getAxisTickMarkLength());
          g.draw(line);
        }
      }
      // Line
      if (getChartPainter().getStyleManager().isAxisTicksLineVisible()) {

        Shape line =
            new Line2D.Double(xOffset, yOffset - getChartPainter().getStyleManager().getAxisTickMarkLength(), xOffset + axisTick.getAxis().getPaintZone().getWidth(), yOffset
                - getChartPainter().getStyleManager().getAxisTickMarkLength());
        g.draw(line);
      }

      // bounds
      bounds =
          new Rectangle2D.Double(xOffset, yOffset - getChartPainter().getStyleManager().getAxisTickMarkLength(), axisTick.getAxis().getPaintZone().getWidth(), getChartPainter().getStyleManager()
              .getAxisTickMarkLength());
      // g.setColor(Color.yellow);
      // g.draw(bounds);
    }
  }

  @Override
  public ChartPainter getChartPainter() {

    return axisTick.getChartPainter();
  }
}
