class UserApi {
  getUser(username, password) {
    return fetch('/api/login', {
      credentials: 'same-origin',
      method: 'POST',
      headers: {
        'username': username,
        'password': password
      }
    })
    .then(response => {
      if (response.status === 200) {
        return response.json();
      } else if (response.status === 404) {
        return null;
      }
      throw Error('Invalid return code: ' + response.status);
    });
  }
}

export default new UserApi();
