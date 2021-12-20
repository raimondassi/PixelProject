import {Form, Formik} from 'formik';
import {Button, CircularProgress, Paper} from '@mui/material';
import * as Yup from 'yup';
import TextFieldInput from "./TextFieldInput";
import Container from "@mui/material/Container";
import '../../style.css'

const validationSchema = Yup.object().shape({
  name: Yup.string()
    .min(5, 'Value must be more than 5')
    .required(),
  category: Yup.string()
    .required(),
  description: Yup.string()
    .max(120, 'Value must be less than 120')
    .required(),
  quantity: Yup.number()
    .typeError('Must be a number')
    .positive()
    .required(),
  price: Yup.number()
    .typeError('Must be a number')
    .positive()
    .required()
});

export default () => (
  <Formik initialValues={{
    name: '',
    category: '',
    description: '',
    quantity: '',
    price: ''
  }}
          onSubmit={(values, helpers) => {
            console.log('values ', values);
            console.log('helpers ', helpers);

            helpers.setSubmitting(true);

            setTimeout(() => {
              helpers.setSubmitting(false);
            }, 5000);

          }}
          validationSchema={validationSchema}>
    {props => (
      <Container maxWidth="sm">
        <Paper elevation={3} sx={{p:1}}>
          <Form className="product-form">
            <TextFieldInput error={props.touched.name && props.errors.name}
                            fieldName="name"
                            label="Name:"
                            placeholder="Type name..."/>
            <TextFieldInput error={props.touched.category && props.errors.category}
                            fieldName="category"
                            label="Category:"/>
            <TextFieldInput error={props.touched.description && props.errors.description}
                            fieldName="description"
                            label="Description:"
                            placeholder="Type description..."
                            multiline
                            rows={3}/>
            <Button > add new pixel</Button>
            <div></div>
            {
              props.isSubmitting ? <CircularProgress/> : <Button type="submit">Submit</Button>
            }
          </Form>
        </Paper>
      </Container>
    )}
  </Formik>
)