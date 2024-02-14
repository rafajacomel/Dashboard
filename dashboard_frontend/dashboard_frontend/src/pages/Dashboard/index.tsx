import React, { useEffect, useMemo, useState } from 'react';

import  ContentHeader  from '../../components/ContentHeader';
import GeneralArchiveInfo from '../../components/GeneralArchiveInfo';

import WarningBox from '../../components/WarningBox';
import main_cards_information from '../../repositories/main_cards_information';
import PieChartBox from '../../components/PieChartBox';
import HistoryBox from '../../components/HistoryBox';
import BarChartBox from '../../components/BarChartBox';
import axios from 'axios';

import { Container,
        Content } from './styles';



const Dashboard: React.FC = () => {

    const urltotalSpaceOccupliedYear = "http://localhost:8080/fixes/space/occupied/year/";

    interface IHistoryDataItem {
        year: string;
        amountChanged: number;
      }
  
    const [historyData, setHistoryData] = useState<IHistoryDataItem[]>([]);

    const total_space = useMemo(() => {
        return String(main_cards_information.total_space) + " TB";
    
    },[]);

    const total_archived = useMemo(() => {
        return String(main_cards_information.total_archived) + " TB";
    
    },[]);

    const total_created = useMemo(() => {
        return String(main_cards_information.total_created) + " TB";
    
    },[]);

    const actual_date = useMemo(() => {
        const currentDate = new Date();
        const formattedDate = currentDate.toLocaleDateString('en-US', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit',
        });

        return "Updated on " + String(formattedDate);

    },[]);
    
    const relation_occupied_free = useMemo(() => {
        const spaceTotal = 100;
        const spaceOccupied = 85;
        const spaceFree = spaceTotal - spaceOccupied;
        
        const percentOccupied = ((spaceOccupied/spaceTotal) * 100);
        const percentFree = ((spaceFree/spaceTotal) * 100);

        const data = [
            {
                name: "Space Occupied",
                value: spaceOccupied,
                percent: Number(percentOccupied.toFixed(1)),
                color:'#E44C4E'
            },

            {
                name: "Space Free",
                value: spaceFree,
                percent: Number(percentFree.toFixed(1)),
                color:'#F7931B'
            },

        ]

        return data;
    
    },[]);

    
    useEffect(() => {
        const fetchHistoryData = async () => {
            try {
                const currentYear = new Date().getFullYear();
                const response = await axios.get(urltotalSpaceOccupliedYear + currentYear);
                console.log(response.data);
  
                const transformedData = Object.entries(response.data).map(([year, amountChanged]) => ({
                    year: String(year),
                    amountChanged: Number(amountChanged),
                }));
                console.log(transformedData);
                setHistoryData(transformedData);
  
            } catch (error) {
              console.error('Error fetching yearly data:', error);
            }
        };
    
        fetchHistoryData();
      }, []);


    const lowHighPublishFixes =useMemo(() => {
        return [
        {   
            name: "Low publish fixes",
            percent: 20,
            color:"#F7931B"
        },
        {   
            name: "High publish fixes",
            percent: 80,
            color:"#E44C4E"
        }
    ]
        
    
    },[]);

    const lowHighDemandFixes =useMemo(() => {
        return [
        {   
            name: "Low demand fixes",
            percent: 35,
            color:"#F7931B"
        },
        {   
            name: "High demand fixes",
            percent: 65,
            color:"#E44C4E"
        }
    ]
        
    
    },[]);
    
    return (
        <Container>
            <ContentHeader title ="Archive dashboard" linecolor='#F7931B'>
              
            </ContentHeader>
            <Content>
                <GeneralArchiveInfo title="Total space on server (in Terabytes):" 
                                    amount={total_space}
                                    footerlabel={actual_date}
                                    color ="#4E41F0"/>
                 <GeneralArchiveInfo title="Total archived this year (in Terabytes):" 
                                    amount= {total_archived}
                                    footerlabel={actual_date} 
                                    color ="#F7931B"/>
                 <GeneralArchiveInfo title="Total created this year(in Terabytes):" 
                                    amount= {total_created}
                                    footerlabel={actual_date}
                                    color ="#E44C4E"/>

                <HistoryBox
                    data = {historyData}
                    lineColorAmountChanged="#F7931B"/>
                    
                <WarningBox />
                <PieChartBox data={relation_occupied_free}/>
                

                <BarChartBox 
                        title="Low and high publish rates (%)"
                        data={lowHighPublishFixes} 
                              />
                <BarChartBox 
                        title="Low and high demand rates (%)"
                        data={lowHighDemandFixes} 
                />
                
            </Content>

        </Container>
    );
    }
export default Dashboard;