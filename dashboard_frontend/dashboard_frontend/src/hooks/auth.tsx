import React, { createContext, useState, useContext, PropsWithChildren } from 'react';

interface IAuthContext {
    logged: boolean;
    signIn(email: string, password: string): void;
    signOut(): void;
}

const AuthContext = createContext<IAuthContext>({} as IAuthContext);

const AuthProvider: React.FC<PropsWithChildren<{}>> = ({ children }) => {
    const [logged, setLogged] = useState<boolean>(() => {
        const isLogged = localStorage.getItem('@sar-dashboard:logged');

        return !!isLogged;
    });

    const signIn = (email: string, password: string) => {
        if(email === 'rafaelmj@ibm.com' && password === '123'){
            localStorage.setItem('@sar-dashboard:logged', 'true');
            setLogged(true);
        }else{
            alert('User or password invalid.');
        }
    }

    const signOut = () => {
        localStorage.removeItem('@sar-dashboard:logged');
        setLogged(false);
    }

    return (
        <AuthContext.Provider value={{logged, signIn, signOut}}>
            {children}
        </AuthContext.Provider>
    );
}

function useAuth(): IAuthContext {
    const context = useContext(AuthContext);

    return context;
}

export { AuthProvider, useAuth };