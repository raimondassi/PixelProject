import HTTP from "./index";

const getPixels = () => HTTP.get('/pixels');
const createPixel = (data) => HTTP.post('/pixel', data);
const getPixelSizes=()=>HTTP.get('/pixelsizes');
const getProducts = () => HTTP.get('/products');
const createProduct = (data) => HTTP.post('/products', data);

export {getProducts, createProduct, getPixels, createPixel, getPixelSizes}


