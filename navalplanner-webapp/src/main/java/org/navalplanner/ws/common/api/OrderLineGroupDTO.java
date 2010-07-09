/*
 * This file is part of NavalPlan
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

package org.navalplanner.ws.common.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.navalplanner.business.orders.entities.OrderLineGroup;

/**
 * DTO for {@link OrderLineGroup} entity.
 *
 * @author Manuel Rego Casasnovas <mrego@igalia.com>
 */
@XmlRootElement(name = "order-line-group")
public class OrderLineGroupDTO extends OrderElementDTO {

    @XmlElementWrapper(name = "children")
    @XmlElements( {
            @XmlElement(name = "order-line", type = OrderLineDTO.class),
            @XmlElement(name = "order-line-group", type = OrderLineGroupDTO.class),
            @XmlElement(name = "order", type = OrderDTO.class) })
    public List<OrderElementDTO> children = new ArrayList<OrderElementDTO>();

    public OrderLineGroupDTO() {
        super();
    }

    public OrderLineGroupDTO(String name, String code,
            XMLGregorianCalendar initDate, XMLGregorianCalendar deadline,
            String description, Set<LabelReferenceDTO> labels,
            Set<MaterialAssignmentDTO> materialAssignments,
            Set<AdvanceMeasurementDTO> advanceMeasurements,
            Set<CriterionRequirementDTO> criterionRequirements,
            List<OrderElementDTO> children) {
        super(name, code, initDate, deadline, description, labels,
                materialAssignments, advanceMeasurements, criterionRequirements);
        this.children = children;
    }

}
