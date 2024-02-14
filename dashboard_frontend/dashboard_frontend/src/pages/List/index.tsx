import React, { useMemo, useState, useEffect } from 'react';
import {v4 as uuidv4} from 'uuid';

import  ContentHeader  from '../../components/ContentHeader';
import { useParams } from 'react-router-dom';
import  SelectInput  from '../../components/SelectInput';
import JobMonitoring from '../../components/JobMonitoring';

import radar_run from '../../repositories/radar_run';
import myna_run from '../../repositories/myna_run';

import formatDate from '../../utils/formatDate';
import listOfMonths from '../../utils/months';

import { Container, Content, Filters } from './styles';

interface IRouteParams {
    job: string;
}

interface IData {
    id: string;
    status: string;
    date: string;
    tagColor: string;
}

const List: React.FC = () => {

    const [data, setData] = useState<IData[]>([]);

    const [monthSelected, setMonthSelected] =  useState<string>(String(new Date().getMonth() + 1)) 

    const [yearSelected, setYearSelected] =  useState<string>(String(new Date().getFullYear())) 

    const [selectedStatus, setSelectedStatus] = useState<string[]>(["Success","Fail"]);

    const { job } = useParams<keyof IRouteParams>() as IRouteParams;

    const title = useMemo(() => {
        return  job === 'entry-myna' ? 'Myna monitoring': 'Radar monitoring'
    }, [job]);

    const linecolor = useMemo(() => {
        return  job === 'entry-myna' ? '#F7931B': '#E44C4E'
    }, [job]);


   const listData = useMemo(() => {
    return  job === 'entry-myna' ? myna_run: radar_run;
    }, [job]);

    

    const years = useMemo(() => {
        let uniqueYears: number[] = [];

        listData.forEach(item => {
            const date = new Date(item.date);
            const year = date.getFullYear();

            if (!uniqueYears.includes(year)) {
                uniqueYears.push(year);
            }
        });

        return uniqueYears.map( year => {
            return{
                value: year,
                label: year,
            }
        });

    }, [listData]);


    const months = useMemo(() => {
            return listOfMonths.map((month, index) => {

                return {
                    value: index + 1 ,
                    label:  month,
                }
            
            });

    }, []);


    const handleStatusClick = (runStatus: string) => {

        const alreadySelected = selectedStatus.findIndex(item => item === runStatus);

        if ( alreadySelected >=0 ) {
            const filtered = selectedStatus.filter(item => item !== runStatus);
            setSelectedStatus(filtered);
            
        } else {
            setSelectedStatus((prev) => [...prev, runStatus ]);
        }


    }

    useEffect(() => {
        const  filteredDate = listData.filter(item => {

            const date = new Date(item.date)
            const month = String(date.getMonth() + 1);
            const year = String(date.getFullYear());
            return month === monthSelected && year === yearSelected && selectedStatus.includes(item.status);
        });

        const formattedData = filteredDate.map(item => { 

            return{
               // id: String(new Date().getTime()) + (Math.random()),
                id: uuidv4(),
                status: item.status,
                date: formatDate(item.date),
                tagColor: item.status === 'Success' ? "#41f067" : "#f04141"
            }
           
        })
        setData(formattedData);
    },[listData, monthSelected, yearSelected, data.length, selectedStatus]);

    return (
        <Container>
        <ContentHeader title ={title} linecolor={linecolor}>
            <SelectInput options= {months} onChange= { (e) => setMonthSelected(e.target.value)} defaultValue={monthSelected}/>
            <SelectInput options= {years} onChange= { (e) => setYearSelected(e.target.value)} defaultValue={yearSelected}/>
        </ContentHeader>

        <Filters>
                <button 
                    type="button"
                    className=
                    {`tag-filter
                    tag-filter-success
                    ${selectedStatus.includes('Success') && 'tag-actived'}`}
                    onClick={() => handleStatusClick('Success')}
                >
                    Success
                </button>

                <button 
                    type="button"
                    className= 
                    {`tag-filter
                    tag-filter-failed
                    ${selectedStatus.includes('Fail') && 'tag-actived'}`}

                    onClick={() => handleStatusClick('Fail')}
                >
                    Fail
                </button>
        </Filters>
        <Content>
            {
                data.map(item =>(
                    <JobMonitoring 
                    key = {item.id}
                    tagColor = {item.tagColor}
                    date = {item.date}
                    status = {item.status}
                    />

                ))
            }
        </Content>

    </Container>
    );
    }
export default List;