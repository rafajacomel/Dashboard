import React, {useMemo} from 'react';

import emojis from '../../utils/emojis';

import { 
    Container,
    HeaderTitle
}  from './styles';

const MainHeader: React.FC = () => {
    const emoji = useMemo(() => {
        const indice = Math.floor(Math.random() * emojis.length )
        return emojis[indice]

    }, [])
    return (
        <Container>
            <HeaderTitle> SAR monitoring tool</HeaderTitle>
        </Container>
    );
}

export default MainHeader;