/**
 * This is intended to serve up a landing page and provide a list of dynamically-configured modules
 * for use in developing the main client SPA, prior to having a real web service to test against.
 */

import * as express from "express";
import * as path from "path";

const app = express();

class ModuleDescriptor {
    constructor(public name: string) { }
}

app.use('/', express.static(path.join(__dirname, '..', 'client')));
app.use('/node_modules', express.static(path.join(__dirname, '..', 'node_modules')));

app.get('/', (httpRequest, httpResponse) => {
    httpResponse.sendFile(path.join(__dirname, '../client/index.html'));
});

app.get('/modules', (httpRequest, httpResponse) => {
    httpResponse.json(getModuleDescriptors());
});

function getModuleDescriptors(): ModuleDescriptor[] {
    return moduleDescriptors;
}

const moduleDescriptors = [
    new ModuleDescriptor('Search')
];

function getModuleByName(moduleName: string) : ModuleDescriptor {
    return moduleDescriptors.find(moduleDescriptor => moduleDescriptor.name === moduleName);
}

app.get('/modules/:name', (httpRequest, httpResponse) => {
    httpResponse.json(getModuleByName(httpRequest.params.name));
});

const httpServer = app.listen(8000, "localhost", () => {
    const { address, port } = httpServer.address();
    console.log('Listening on %s, port %s', address, port);
});

