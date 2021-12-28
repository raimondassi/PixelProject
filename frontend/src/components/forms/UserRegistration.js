import {Form, Formik} from 'formik';
import {Button, CircularProgress, Paper} from '@mui/material';
import * as Yup from 'yup';
import TextFieldInput from "./TextFieldInput";
import Container from "@mui/material/Container";
import '../../style.css'

const validationSchema = Yup.object().shape({
  loginName: Yup.string()
    .required('User name is required'),
  password: Yup.string()
    .required('Password is required'),
  repeatPassword: Yup.string()
    .oneOf([Yup.ref('password'), null], 'Passwords must be the same')
});

export default () => (
  <Formik initialValues={{
    loginName: '',
    password: '',
    repeatPassword: ''
  }}
          onSubmit={(values, helpers) => {

            helpers.setSubmitting(true);

            setTimeout(() => {
              helpers.setSubmitting(false);
            }, 5000);

          }}
          validationSchema={validationSchema}>
    {props => (
      <Container maxWidth="sm">
        <Paper elevation={3} sx={{p: 1}}>
          <Form className="product-form">
            <TextFieldInput error={props.touched.loginName && !!props.errors.loginName}
                            fieldName="loginName"
                            label="login name:"
                            placeholder="Type login name..."/>
            <TextFieldInput error={props.touched.password && !!props.errors.password}
                            fieldName="password"
                            label="Password:"
                            placeholder="Type password..."
                            type="password"/>
            <TextFieldInput error={props.touched.repeatPassword && !!props.errors.repeatPassword}
                            fieldName="repeatPassword"
                            label="Repeat Password:"
                            placeholder="Repeat password..."
                            type="password"/>
            {
              props.isSubmitting ? <CircularProgress/> : <Button variant="outlined" type="submit">Submit</Button>
            }
          </Form>
        </Paper>
      </Container>
    )}
  </Formik>
)