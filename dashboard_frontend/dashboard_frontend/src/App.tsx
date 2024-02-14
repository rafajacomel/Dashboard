import React, { PropsWithChildren } from 'react';
import { ThemeProvider } from 'styled-components';
import GlobalStyles from './styles/GlobalStyles';
import dark from './styles/themes/dark'
import Routes from './routes';


const App: React.FC<PropsWithChildren<{}>> = ({ children })  => {
    //const {theme} = useTheme();
    
    return (
        <ThemeProvider theme = {dark}>
        <GlobalStyles />
            <Routes></Routes>
        </ThemeProvider>
    );
}

export default App;