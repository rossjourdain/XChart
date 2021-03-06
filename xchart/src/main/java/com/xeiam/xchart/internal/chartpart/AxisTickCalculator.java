/**
 * Copyright 2013 Xeiam LLC.
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

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.xeiam.xchart.StyleManager;
import com.xeiam.xchart.StyleManager.ChartType;
import com.xeiam.xchart.internal.Utils;
import com.xeiam.xchart.internal.chartpart.Axis.Direction;

/**
 * @author timmolter
 */
public abstract class AxisTickCalculator {

  /** the default tick mark step hint for x axis */
  protected static final int DEFAULT_TICK_MARK_STEP_HINT_X = 74;

  /** the default tick mark step hint for y axis */
  protected static final int DEFAULT_TICK_MARK_STEP_HINT_Y = 44;

  /** the List of tick label position in pixels */
  protected List<Integer> tickLocations = new LinkedList<Integer>();;

  /** the List of tick label values */
  protected List<String> tickLabels = new LinkedList<String>();

  protected final Direction axisDirection;

  protected final int workingSpace;

  protected final BigDecimal minValue;

  protected final BigDecimal maxValue;

  protected final StyleManager styleManager;

  /**
   * Constructor
   * 
   * @param axisDirection
   * @param workingSpace
   * @param minValue
   * @param maxValue
   * @param styleManager
   */
  public AxisTickCalculator(Direction axisDirection, int workingSpace, BigDecimal minValue, BigDecimal maxValue, StyleManager styleManager) {

    // override min/max value for bar charts' Y-Axis
    BigDecimal overrideMinValue = minValue;
    BigDecimal overrideMaxValue = maxValue;
    if (styleManager.getChartType() == ChartType.Bar && axisDirection == Direction.Y) { // this is the Y-Axis for a bar chart
      if (minValue.compareTo(BigDecimal.ZERO) > 0 && maxValue.compareTo(BigDecimal.ZERO) > 0) {
        overrideMinValue = BigDecimal.ZERO;
      }
      if (minValue.compareTo(BigDecimal.ZERO) < 0 && maxValue.compareTo(BigDecimal.ZERO) < 0) {
        overrideMaxValue = BigDecimal.ZERO;
      }
    }

    if (styleManager.getChartType() == ChartType.Bar && styleManager.isYAxisLogarithmic()) {
      int logMin = (int) Math.floor(Math.log10(minValue.doubleValue()));
      overrideMinValue = new BigDecimal(Utils.pow(10, logMin).doubleValue());
    }

    // override min and maxValue if specified
    if (axisDirection == Direction.X && styleManager.getXAxisMin() != null) {
      overrideMinValue = new BigDecimal(styleManager.getXAxisMin());
    }
    if (axisDirection == Direction.Y && styleManager.getYAxisMin() != null) {
      overrideMinValue = new BigDecimal(styleManager.getYAxisMin());
    }
    if (axisDirection == Direction.X && styleManager.getXAxisMax() != null) {
      overrideMaxValue = new BigDecimal(styleManager.getXAxisMax());
    }
    if (axisDirection == Direction.Y && styleManager.getYAxisMax() != null) {
      overrideMaxValue = new BigDecimal(styleManager.getYAxisMax());
    }
    this.axisDirection = axisDirection;
    this.workingSpace = workingSpace;
    this.minValue = overrideMinValue;
    this.maxValue = overrideMaxValue;
    this.styleManager = styleManager;
  }

  BigDecimal getFirstPosition(BigDecimal gridStep) {

    BigDecimal firstPosition;
    if (minValue.remainder(gridStep).doubleValue() <= 0.0) {
      firstPosition = minValue.subtract(minValue.remainder(gridStep));
    }
    else {
      firstPosition = minValue.subtract(minValue.remainder(gridStep)).add(gridStep);
    }
    return firstPosition;
  }

  public List<Integer> getTickLocations() {

    return tickLocations;
  }

  public List<String> getTickLabels() {

    return tickLabels;
  }

}
