import HTTP from "./index";

const generatePicture = (pixelList) => HTTP.post("/picture", pixelList);
const createOrder=(data)=>HTTP.post("/order", data);
const login = (data) => HTTP.post('/login', data);

export {generatePicture, createOrder, login}


