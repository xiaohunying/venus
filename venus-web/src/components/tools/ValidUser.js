function ValidUser(user) {
  if (user !== null && user !== undefined && user.id > 0) {
    return true;
  } else {
    return false;
  }
}

export default ValidUser;
