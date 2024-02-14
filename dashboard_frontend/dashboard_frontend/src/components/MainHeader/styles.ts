import styled from 'styled-components';


export const Container = styled.div`
    grid-area: MH;
    
    background-color: ${props => props.theme.colors.secondary};
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0px 10px;

    border-bottom: 1px solid ${props => props.theme.colors.gray};
`;



export const HeaderTitle = styled.h1`
    display: center;
    align-content: center;
    color: ${props => props.theme.colors.white};
`;

