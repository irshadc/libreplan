/*
 * This file is part of ###PROJECT_NAME###
 *
 * Copyright (C) 2009 Fundación para o Fomento da Calidade Industrial e
 *                    Desenvolvemento Tecnolóxico de Galicia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.navalplanner.web.planner.chart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.joda.time.LocalDate;
import org.navalplanner.business.planner.entities.DayAssignment;
import org.navalplanner.business.resources.entities.Resource;
import org.zkforge.timeplot.Timeplot;
import org.zkforge.timeplot.geometry.TimeGeometry;
import org.zkforge.timeplot.geometry.ValueGeometry;
import org.zkoss.ganttz.util.Interval;

/**
 * Contract for {@link ChartFiller}.
 *
 * @author Manuel Rego Casasnovas <mrego@igalia.com>
 */
public interface IChartFiller {

    void fillChart(Timeplot chart, Interval interval, Integer size);

    TimeGeometry getTimeGeometry(Interval interval);

    ValueGeometry getValueGeometry();

    SortedMap<LocalDate, Map<Resource, Integer>> groupDayAssignmentsByDayAndResource(
            List<DayAssignment> dayAssignments);

    void addCost(SortedMap<LocalDate, BigDecimal> currentCost,
            SortedMap<LocalDate, BigDecimal> additionalCost);

    SortedMap<LocalDate, BigDecimal> accumulateResult(
            SortedMap<LocalDate, BigDecimal> map);

    SortedMap<LocalDate, BigDecimal> convertToBigDecimal(
            SortedMap<LocalDate, Integer> map);

}
