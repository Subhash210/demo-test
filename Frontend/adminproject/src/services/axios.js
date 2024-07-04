import axios from 'axios';

const API_BASE_URL = 'http://localhost:7001/api/v0/user';

export const fetchData = async (endpoint) => {
  try {
    const response = await axios.get(`${API_BASE_URL}/${endpoint}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

export const sendData = async (endpoint, data) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/${endpoint}`, data);
    return response.data;
  } catch (error) {
    console.error('Error sending data:', error?.response?.data);
    if (error?.response?.data.title == "Error") {
      alert(error?.response?.data.message);
    }
  }
};

