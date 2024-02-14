import React from 'react';
import {
    ResponsiveContainer,
    BarChart,
    Bar,
    Cell,
    Tooltip,
} from 'recharts';

//import formatCurrency from '../../utils/formatCurrency';

import { 
    Container,
    SideLeft,
    SideRight,
    LegendContainer,
    Legend,
}  from './styles';

interface IBarChartProps {
    title: string;
    data: {
        name: string;
        percent: number;
        color: string;
    }[],
}

const BarChartBox: React.FC<IBarChartProps> = ({
    title,
    data
}) => (
        <Container>
            <SideLeft>
                <h3>{title}</h3>
                <br/>
                <LegendContainer>
                    {
                        data.map((indicator) => (
                            <Legend key={indicator.name} color={indicator.color}>
                            <div>{indicator.percent}%</div>
                            <span>{indicator.name}</span>
                            </Legend>  
                        ))              
                    }
                </LegendContainer>
            </SideLeft>
            
            
            <SideRight>
            <ResponsiveContainer>
                    <BarChart data={data}>                    
                        <Bar dataKey="percent" name="Value">
                            {
                                data.map((indicator) => (
                                    <Cell 
                                        key={indicator.name}
                                        fill={indicator.color}
                                        cursor="pointer"    
                                    />
                                ))
                            }
                        </Bar>   
                        <Tooltip 
                            cursor={{fill: 'none'}}
                            formatter={(value) => Number(value) + "%"} 
                        />
                    </BarChart>
                </ResponsiveContainer>
               
            </SideRight>       
        </Container>
    );

export default BarChartBox;