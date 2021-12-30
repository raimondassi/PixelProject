import {Form, Formik} from 'formik';
import {Button, Paper} from '@mui/material';
import * as Yup from 'yup';
import TextFieldInput from "./TextFieldInput";
import Container from "@mui/material/Container";
import '../../style.css'
import {createNewUser} from "../../api/restApi";
import {useState} from "react";

const validationSchema = Yup.object().shape({
  username: Yup.string()
    .required('User name is required'),
  password: Yup.string()
    .required('Password is required'),
  repeatPassword: Yup.string()
    .oneOf([Yup.ref('password'), null], 'Passwords must be the same')
});

export default () => {
  const [notification, setNotification] = useState({isVisible: false, message: '', severity: ''});

  const onCreateNewUser = (values, helpers) => {
    createNewUser(values)
      .then(({status}) => {
        if (status === 201) {
          setNotification({isVisible: true, message: 'User created successfully', severity: 'success'});
          helpers.resetForm();
        }
      })
      .catch((error) => setNotification({isVisible: true, message: 'Something goes wrong', severity: 'error'}))
      .finally(() => helpers.setSubmitting(false));
  }

  return (
    <Formik initialValues={{
      username: '',
      password: '',
      repeatPassword: ''
    }}
            onSubmit={onCreateNewUser}
            validationSchema={validationSchema}
    >
      {props => (
        <Container maxWidth="sm">
          <Paper elevation={3} sx={{p: 1}}>
            <Form className="product-form">
              <TextFieldInput error={props.touched.username && !!props.errors.username}
                              fieldName="username"
                              label="user name:"
                              placeholder="Type user name..."/>
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
              <Button variant="outlined" type="submit" disabled={props.isSubmitting}>Submit</Button>
            </Form>
          </Paper>
        </Container>
      )}
    </Formik>
  )
}