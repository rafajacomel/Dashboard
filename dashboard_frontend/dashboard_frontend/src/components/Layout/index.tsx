import React, { PropsWithChildren } from 'react';

import MainHeader from '../MainHeader';
import Aside from '../Aside';
import Content from '../Content';


import { 
    Grid
}  from './styles';

const Layout: React.FC<PropsWithChildren<{}>> = ({ children })  => {
    return (
        <Grid>
            <MainHeader></MainHeader>
            <Aside></Aside>
            <Content>
                {children }
            </Content>
        </Grid>
    );
}

export default Layout;