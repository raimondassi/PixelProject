import {Form, Formik} from 'formik';
import {Button, CircularProgress, Paper} from '@mui/material';
import * as Yup from 'yup';
import TextFieldInput from "./TextFieldInput";
import Container from "@mui/material/Container";
import '../../style.css';
import {createOrder} from "../../api/restApi";
import * as React from "react";
import {useState} from "react";
import Box from "@mui/material/Box";
import {useSelector} from "react-redux";
import HelperText from "../component/HelperText";

const validationSchema = Yup.object().shape({
  name: Yup.string()
    .required('Name is required'),
  surname: Yup.string()
    .required('Surname is required'),
  country: Yup.string()
    .required('Country is required'),
  city: Yup.string()
    .required('City is required'),
  street: Yup.string()
    .required('Street is required'),
  zipcode: Yup.string()
    .required('Zip code is required'),
  phone: Yup.string()
    .required('Phone is required'),
  email: Yup.string()
    .email()
    .required(),
  description: Yup.string()
    .required('Please give any description to your order')
});
export default () => {
  const picture=useSelector(store=>store.picture);
  return(
    <>
      <div style={{width: '100%', textAlign:'center',marginTop:3}}>
        <h2>Product you will order</h2>
      <Box sx={{
        display: 'flex',
        justifyContent: 'space-evenly',
        p: 1,
        m: 1,
        bgcolor: 'background.paper',
      }}>
        <Box component="img" sx={{width: '90%', height: 300, borderRadius: 2}}
             src={`data:image/jpeg;base64,${picture}`}>
        </Box>
      </Box>
        </div>

      <Formik initialValues={{
        name: '',
        surname: '',
        country: '',
        city:'',
        street:'',
        zipcode:'',
        phone:'',
        email: '',
        description:''
      }}

              onSubmit={(values, helpers) => {
                helpers.setSubmitting(true);
                setTimeout(() => {
                  helpers.setSubmitting(false);
                }, 5000);
                const [notification, setNotification] = useState({isVisible: false, message:'', severity: ''});
                createOrder(values)
                  .then(({status}) => {
                    if(status === 201) {
                      setNotification({isVisible: true, message: 'Order created successfully', severity: 'success'});
                      helpers.resetForm();
                    }
                  })
                  .catch((error) => setNotification({isVisible: true, message: 'Something goes wrong', severity: 'error'}))
                  .finally(() => helpers.setSubmitting(false));
              }}


              validationSchema={validationSchema}>
        {props => (
          <Container maxWidth="sm">
            <Paper elevation={3} sx={{p: 1}}>
              <Form className="product-form">
                <h2>Customer details: </h2>
                <TextFieldInput error={props.touched.name && !!props.errors.name}
                                fieldName="name"
                                label="Name:"
                                placeholder="Type name..."/>
                <TextFieldInput error={props.touched.surname && !!props.errors.surname}
                                fieldName="surname"
                                label="Surname:"
                                placeholder="Type surname..."/>
                <TextFieldInput error={props.touched.country && !!props.errors.country}
                                fieldName="country"
                                label="Country:"
                                placeholder="Type country..."/>
                <TextFieldInput error={props.touched.city && !!props.errors.city}
                                fieldName="city"
                                label="City:"
                                placeholder="Type city..."/>
                <TextFieldInput error={props.touched.street && !!props.errors.street}
                                fieldName="street"
                                label="Street:"
                                placeholder="Type street..."/>
                <TextFieldInput error={props.touched.zipcode && !!props.errors.zipcode}
                                fieldName="zipcode"
                                label="Zip code:"
                                placeholder="Type zip code..."/>
                <TextFieldInput error={props.touched.phone && !!props.errors.phone}
                                fieldName="phone"
                                label="Phone:"
                                placeholder="Type phone..."/>
                <TextFieldInput error={props.touched.email && !!props.errors.email}
                                fieldName="email"
                                label="Email:"
                                placeholder="Type email..."/>
                <TextFieldInput error={props.touched.description && !!props.errors.description}
                                fieldName="description"
                                label="Description:"
                                placeholder="Type description of your order..."/>
                {
                  props.isSubmitting ? <CircularProgress/> : <Button variant="outlined" type="submit">Submit</Button>
                }
                <HelperText name="Delivery period is 30 days from order"/>
              </Form>
            </Paper>
          </Container>
        )}
      </Formik>
    </>


  )
}