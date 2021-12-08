/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-08 22:38:36
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-08 22:40:09
 * @Description:
 */
export const loginStorage = (user: any) => {
  localStorage.setItem("userId", user.userId);
  localStorage.setItem("userInfo", JSON.stringify(user));
};
export const logoutStorage = () => {
  localStorage.setItem("userId", "");
  localStorage.setItem("userInfo", "");
};
