import React from 'react';

import { Container }  from './styles';



const WarningBox: React.FC = ({
})  => {
    return (
        <Container>
            <header>
                <h4>Warning you have one or more directories with high disk space usage:</h4>
                <p>/home/webapps/sar/download/CMA: 94% full</p>
            </header>
        </Container>
    );
}

export default WarningBox;