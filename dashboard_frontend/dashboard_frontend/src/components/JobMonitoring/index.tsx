import React from 'react';

import { Container, Tag }  from './styles';

interface IJobMonitoring {
    tagColor: string;
    date: string;
    status: string;
    
}

const JobMonitoring: React.FC<IJobMonitoring> = ({
    tagColor, 
    date,
    status
})  => {

    return (
        <Container>
            <Tag color = {tagColor}/>
            <div>
                <span>{date}</span>
            </div>
            <h3>{status}</h3>
        </Container>
    );
}

export default JobMonitoring;