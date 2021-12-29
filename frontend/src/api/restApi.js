import HTTP from "./index";

const generatePicture = (pixelList) => HTTP.post("/api/picture", pixelList);
const createOrder=(data)=>HTTP.post("/api/order", data);
const login = (data) => HTTP.post('/login', data);
const createNewUser=(data)=>HTTP.post('/api/createuser', data);


export {generatePicture, createOrder, login, createNewUser}


