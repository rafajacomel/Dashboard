import styled from 'styled-components';


export const Container = styled.div`
    grid-area: AS;
    color: ${props => props.theme.colors.white};
    background-color:  ${props => props.theme.colors.secondary};
    padding-left: 20px;

    border-right: 1px solid ${props => props.theme.colors.gray};

`;

export const MenuContainer = styled.nav`
    display: flex;
    flex-direction: column;


    margin-top: 50px;
`;

export const MenuItemLink = styled.a`
    color: ${props => props.theme.colors.info};
    text-decoration: none;

    margin: 7px 0;
    display: flex;
    align-items: center;
    font-size: 25px;

    transition: opacity .3s;

    &:hover {
        opacity: .7;
    }
`;

export const MenuItemButton = styled.button`
    font-size: 26px;
    color: ${props => props.theme.colors.info};
    
    border: none;
    background: none;

    margin: 7px 0;
    display: flex;
    align-items: center;

    transition: opacity .3s;

    &:hover {
        opacity: .7;
    }

    > svg {
        font-size: 18px;
        margin-right: 5px;
    }
`;
