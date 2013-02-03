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
package com.xeiam.xchart.demo.charts;

import java.util.Arrays;
import java.util.Collection;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.SwingWrapper;
import com.xeiam.xchart.style.Series;
import com.xeiam.xchart.style.SeriesMarker;

/**
 * Manual Data
 * 
 * @author timmolter
 */
public class Example1 implements ExampleChart {

  public static void main(String[] args) {

    ExampleChart exampleChart = new Example1();
    Chart chart = exampleChart.getChart();
    new SwingWrapper(chart).displayChart();
  }

  @Override
  public Chart getChart() {

    // data
    Number[] xDataArray = new Number[] { 0.0, 0.03139525976465669, 0.06266661678215213, 0.0936906572928623, 0.1243449435824274, 0.1545084971874737, 0.184062276342339, 0.21288964578253636,
        0.24087683705085766, 0.26791339748949833, 0.29389262614623657, 0.3187119948743448, 0.34227355296434425, 0.3644843137107057, 0.38525662138789457, 0.4045084971874737, 0.42216396275100754,
        0.43815334002193185, 0.4524135262330098, 0.46488824294412573, 0.4755282581475768, 0.4842915805643156, 0.49114362536434436, 0.49605735065723894, 0.4990133642141358, 0.5, 0.4990133642141358,
        0.4960573506572389, 0.4911436253643443, 0.4842915805643155, 0.4755282581475767, 0.46488824294412556, 0.4524135262330097, 0.4381533400219316, 0.42216396275100737, 0.4045084971874735,
        0.38525662138789435, 0.36448431371070544, 0.342273552964344, 0.31871199487434443, 0.29389262614623607, 0.2679133974894978, 0.24087683705085702, 0.21288964578253586, 0.18406227634233846,
        0.15450849718747314, 0.12434494358242676, 0.09369065729286163, 0.0626666167821514, 0.0313952597646559, -6.049014748177263E-16, -0.03139525976465733, -0.06266661678215281,
        -0.09369065729286304, -0.12434494358242815, -0.1545084971874745, -0.1840622763423398, -0.21288964578253713, -0.24087683705085847, -0.26791339748949894, -0.29389262614623723,
        -0.31871199487434554, -0.342273552964345, -0.3644843137107064, -0.38525662138789524, -0.40450849718747445, -0.42216396275100815, -0.43815334002193224, -0.45241352623301023,
        -0.46488824294412606, -0.47552825814757715, -0.4842915805643158, -0.4911436253643446, -0.49605735065723905, -0.4990133642141359, -0.5, -0.49901336421413567, -0.49605735065723877,
        -0.491143625364344, -0.4842915805643152, -0.47552825814757643, -0.4648882429441252, -0.4524135262330092, -0.438153340021931, -0.42216396275100676, -0.4045084971874727, -0.3852566213878937,
        -0.36448431371070455, -0.3422735529643432, -0.31871199487434343, -0.29389262614623524, -0.26791339748949666, -0.2408768370508561, -0.2128896457825349, -0.18406227634233727,
        -0.15450849718747214, -0.12434494358242552, -0.0936906572928606, -0.06266661678215013, -0.03139525976465486, 2.097981369335578E-15 };
    Collection<Number> xData = Arrays.asList(xDataArray);

    Number[] yDataArray = new Number[] { 0.0, 1.5702142318133935E-5, 3.13688735543879E-5, 4.703341403158832E-5, 6.303295245179154E-5, 8.092859563778825E-5, 1.0594882618710001E-4,
        1.558236372723155E-4, 2.7329707705089635E-4, 5.199254519985949E-4, 9.014386029378818E-4, 0.0013306621873173169, 0.0017306604364273927, 0.0020715324272834947, 0.0023569051679597362,
        0.0025927070538466638, 0.0027886026991513404, 0.002952502529028644, 0.0030880047369627284, 0.0032003236220216743, 0.003291666404197254, 0.0033648801628904596, 0.003421046591348078,
        0.0034608642835927588, 0.0034853783634585696, 0.0034948715689020367, 0.0034897171052496183, 0.0034701613190169425, 0.0034365427075935128, 0.003389087289131133, 0.0033280335272856142,
        0.003253771246701497, 0.0031666186473881487, 0.00306689011690467, 0.0029550247059562454, 0.0028314794027288065, 0.0026967349463042378, 0.002551357830616439, 0.002395898998210993,
        0.0022309713675244328, 0.002057244774600177, 0.0018753905860785436, 0.0016861342273231793, 0.0014902252697364343, 0.0012884341340577633, 0.0010815578443189703, 8.704131639000351E-4,
        6.558335341671071E-4, 4.3866560733456445E-4, 2.19766427583401E-4, -4.234301271122286E-18, -2.1976644564027456E-4, -4.3866524602280996E-4, -6.558321784509378E-4, -8.703966842877769E-4,
        -0.0010814873042787273, -0.0012881467574255387, -0.0014891336787390336, -0.0016823672042564418, -0.0018627630869467102, -0.0020181202111633698, -0.002119632929541168, -0.002114609338758541,
        -0.0019593967275554746, -0.0016730082089855846, -0.0013440006960966345, -0.0010483972455089105, -8.149512680002023E-4, -6.433644138995512E-4, -5.209373197845712E-4, -4.34946817866983E-4,
        -3.7661743777884615E-4, -3.3739281674167966E-4, -3.099970594128415E-4, -2.9070472170425525E-4, -2.77636367693098E-4, -2.68102425931983E-4, -2.6019714020176945E-4, -2.536145792301906E-4,
        -2.4744573769866404E-4, -2.4122358912925663E-4, -2.3473774775902484E-4, -2.2772135357722773E-4, -2.2006305955750752E-4, -2.1171197663128998E-4, -2.026763153011749E-4, -1.928814887412768E-4,
        -1.8242620113215842E-4, -1.712818057089484E-4, -1.5947175495155755E-4, -1.470534737044005E-4, -1.340464949116753E-4, -1.2051929111759324E-4, -1.0651565202537847E-4, -9.209212285608304E-5,
        -7.730521584738858E-5, -6.221344753211741E-5, -4.687672566856378E-5, -3.135450711247751E-5, -1.5708413280955366E-5, 1.0498035802487025E-18 };
    Collection<Number> yData = Arrays.asList(yDataArray);

    // Create Chart
    Chart chart = new Chart(800, 600);

    // Customize Chart
    chart.setTitle("Example1");
    chart.getStyleManager().setChartTitleVisible(false);
    chart.getStyleManager().setChartLegendVisible(false);

    // Series 1
    Series series1 = chart.addSeries("data", xData, yData);
    series1.setMarker(SeriesMarker.NONE);

    return chart;
  }
}
