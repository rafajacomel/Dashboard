import React, {useState} from 'react';

import logoImg from '../../assets/ibm-logo.svg';

import Input from '../../components/Input';
import Button from '../../components/Button';

import { useAuth } from '../../hooks/auth';

import {
    Container,
    Logo,
    Form,
    FormTitle,
} from './styles';

const SignIn: React.FC = () => {
    const [email, setEmail] = useState<string>('');
    const [password, setPassword] = useState<string>('');    

    const { signIn } = useAuth();

    return (
        <Container>
            <Logo>
                <img src={logoImg} alt="SAR monitoring tool" />
                <h3>SAR monitoring tool</h3>
            </Logo>

            <Form onSubmit={() => signIn(email, password)}>
                <FormTitle>Singin</FormTitle>

                <Input 
                    type="email"
                    placeholder="e-mail"
                    required
                    onChange={(e) => setEmail(e.target.value)}
                />
                <Input 
                    type="password"
                    placeholder="senha"
                    required
                    onChange={(e) => setPassword(e.target.value)}
                />
               <Button type="submit">Singin</Button>
            </Form>
        </Container>
    );
}

export default SignIn;