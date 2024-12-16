function buildUrl(url, options = {}) {
  let baseUrl = typeof url === "string" ? url : "";
  const queryParams = options.queryParams || {};
  const queryString = Object.keys(queryParams)
    .map((key) => `${encodeURIComponent(key)}=${encodeURIComponent(queryParams[key])}`)
    .join("&");

  if (typeof url === "object") {
    baseUrl = "";
    options = url;
  }

  if (options.path) {
    baseUrl += `/${options.path}`;
  }

  if (queryString) {
    baseUrl += `?${queryString}`;
  }

  if (options.hash) {
    baseUrl += `#${options.hash}`;
  }

  return baseUrl;
}
