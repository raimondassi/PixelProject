import HTTP from "./index";

const generatePicture = (data) => HTTP.post("/picture", data);

export {generatePicture}


