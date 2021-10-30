exports.handler = async (event) => {
    console.log('***** Incoming event:', event);
    if (event.identitySource) {
        const token = event.identitySource[0].replace(/Basic /g, '');
        const credentials = Buffer.from('admin:secret').toString('base64');
        const isAuthorized = token === credentials;
        return { isAuthorized };
    } else {
        throw Error("missing identitySource, event: " + JSON.stringify(event));
    }
};
