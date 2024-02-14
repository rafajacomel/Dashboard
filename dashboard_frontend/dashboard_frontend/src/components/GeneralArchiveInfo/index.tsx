import React, { PropsWithChildren } from 'react';

import { 
    Container
}  from './styles';

interface IGeneralArchiveInfoProps {
    title: string;
    amount: string;
    footerlabel: string;
    color: string;
}

const GeneralArchiveInfo: React.FC<IGeneralArchiveInfoProps> = ({
    title,
    amount,
    footerlabel,
    color
})  => {
    return (
        <Container color={color}>
            <span>{title}</span>
            <h1>{amount}</h1>
            <small>{footerlabel}</small>
        </Container>
    );
}

export default GeneralArchiveInfo;