import styled from "styled-components";




interface ITagProps {
    color: string;

}

export const Container = styled.li`
    background-color: ${props => props.theme.colors.tertiary};
    list-style: none;
    border-radius: 6px;
    margin: 10px 0;
    padding: 12px 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    cursor: pointer; 
    transition: all .3;

    position: relative;

    &:hover {
        opacity: 0.7;
        transform: translatex(10px);
    }

    > div {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        padding-left: 10px;
    }

    > div span {
        font-weight: bold;
        font-size: 18px;
    }

    
`;

export const Tag = styled.div<ITagProps>`
    width: 15px;
    height: 70%;
    position: absolute;

    background-color: ${props => props.color};

    left:0;

`;
