import React from 'react';
import {
    ResponsiveContainer,
    LineChart,
    Line,
    XAxis,
    CartesianGrid,
    Tooltip,
    YAxis,
} from 'recharts';

import { 
    Container, 
    ChartContainer,
    Header,
    LegendContainer,
    Legend,
}  from './styles';


interface IHistoryBoxProps {
    data: {
        year: string,
        amountChanged: number,
    }[],
    lineColorAmountChanged: string;
}

const HistoryBox: React.FC<IHistoryBoxProps> = ({
    data, lineColorAmountChanged
}) => (
    <Container>
        <Header>
            <h2>General growth since 2008 (in TB)</h2>

            <LegendContainer>
                <Legend color={lineColorAmountChanged}>
                    <div></div>
                    <span>General growth per yer (in TB)</span>
                </Legend>
           
            </LegendContainer>
        </Header>

        <ChartContainer>
            <ResponsiveContainer>
                <LineChart data={data} margin={{ top: 5, right: 20, left: 20, bottom: 5 }}>
                    <CartesianGrid strokeDasharray="3 3" stroke="#cecece" />
                    <XAxis dataKey="year" stroke="#cecece" />

                    <Tooltip/>
                    <Line 
                        type="monotone"                
                        dataKey="amountChanged"
                        name="Total amount in this year (in TB)"
                        stroke={lineColorAmountChanged}
                        
                    />
                </LineChart>
            </ResponsiveContainer>
        </ChartContainer>
    </Container>
)

export default HistoryBox;