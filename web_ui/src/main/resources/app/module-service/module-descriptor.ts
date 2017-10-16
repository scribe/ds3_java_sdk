/**
 * Associate a display name with a navigation url.
 */

export class ModuleDescriptor {
    name: string;
    url: string;

    constructor(name: string, url: string) {
        this.name = name;
        this.url = url;
    }
}