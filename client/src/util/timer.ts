/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-09 22:30:48
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-09 22:42:32
 * @Description:
 */
export function JsDateTimer(unixtime: any) {
  if (!unixtime) {
    return "";
  }
  var date = new Date(unixtime);
  var y: any = date.getFullYear();
  var m: any = date.getMonth() + 1;
  m = m < 10 ? "0" + m : m;
  var d: any = date.getDate();
  d = d < 10 ? "0" + d : d;
  var h: any = date.getHours();
  h = h < 10 ? "0" + h : h;
  var minute: any = date.getMinutes();
  var second: any = date.getSeconds();
  minute = minute < 10 ? "0" + minute : minute;
  second = second < 10 ? "0" + second : second;
  // return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;//年月日时分秒
  return y + "/" + m + "/" + d + " " + h + ":" + minute;
}
