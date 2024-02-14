import React from 'react';

import { useAuth } from '../../hooks/auth';

import { 
    Container,
    MenuContainer,
    MenuItemLink,
    MenuItemButton
}  from './styles';

const Aside: React.FC = () => {

    const {signOut} = useAuth();
    return (
        <Container>
            <MenuContainer>
                <MenuItemLink href="/dashboard">
                    Archive dashboard
                </MenuItemLink>
                <MenuItemLink href="/list/entry-myna">
                    Myna monitoring
                </MenuItemLink>
                <MenuItemLink href="/list/entry-radar">
                    Radar monitoring
                </MenuItemLink>
                <MenuItemLink href="#">
                    Other
                </MenuItemLink>
                <MenuItemButton onClick={signOut}>
                    Log out
                </MenuItemButton>
            </MenuContainer>
        </Container>
    );
}

export default Aside;