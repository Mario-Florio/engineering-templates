import readline from 'readline';
import Controller from './interface-adapters/controllers/Controller.js';

(async function run() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    await mainMenu(rl);
})();

// UTILS
const tokens = {
    CREATE: 'CREATE',
    READ: 'READ',
    READONE: 'READONE',
    UPDATE: 'UPDATE',
    DELETE: 'DELETE',
    EXIT: 'EXIT',
    MAINMENU: 'MAINMENU'
}

const dispatcher = {
    [tokens.CREATE]: async (rl) => {
        const data = await getData(rl);
        return Controller.create({ data });
    },
    [tokens.READ]: async (rl) => {
        const filter = await getFilter(rl);
        return Controller.read({ filter });
    },
    [tokens.READONE]: async (rl) => {
        const filter = await getFilter(rl);
        return Controller.readOne({ filter });
    },
    [tokens.UPDATE]: async (rl) => {
        const id = await getId(rl);
        const updatedData = await getData(rl);
        return Controller.update({ id, updatedData });
    },
    [tokens.DELETE]: async (rl) => {
        const id = await getId(rl);
        return Controller.remove({ id });
    },
    [tokens.EXIT]: async (rl) => {
        await rl.close()
        console.log("Exiting now...");
        process.exit(0);
    },
    [tokens.MAINMENU]: async (rl) => await mainMenu(rl)
}

function questionAsync(query, rl) {
    return new Promise(resolve => rl.question(query, resolve));
}

async function mainMenu(rl) {
    const question = '\n'+
                     '1. Create\n'+
                     '2. Read\n'+
                     '3. ReadOne\n'+
                     '4. Update\n'+
                     '5. Delete\n'+
                     '6. exit\n';

    const answer = await questionAsync(question, rl);
    const response = await dispatcher[parseAnswer(answer)](rl);
    response && response.success && console.log(response.data);
    mainMenu(rl);
}

async function getId(rl) {
    const answer = await questionAsync('Input id: \n', rl);
    return answer;
}

async function getData(rl) {
    try {
        const answer = await questionAsync('Input data (must be valid json): \n', rl);
        const data = JSON.parse(answer);
        return data;
    } catch (err) {
        console.log('Input was not valid json\n');
        await getData(rl);
    }
}

async function getFilter(rl) {
    try {
        const answer = await questionAsync('Filter (must be valid json): \n', rl);
        const data = JSON.parse(answer);
        return data;
    } catch (err) {
        console.log('Filter must be valid json\n');
        await getFilter(rl);
    }
}

function parseAnswer(answer) {
    switch(answer.toLowerCase()) {
        case '1':
        case 'create':
        case '1. create':
            return tokens.CREATE;
        case '2':
        case 'read':
        case '2. read':
            return tokens.READ;
        case '3':
        case 'readone':
        case '3.readone':
            return tokens.READONE;
        case '4':
        case 'update':
        case '4. update':
            return tokens.UPDATE;
        case '5':
        case 'delete':
        case '5. delete':
            return tokens.DELETE;
        case '6':
        case 'exit':
        case '6. exit':
            return tokens.EXIT;
        default:
            return tokens.MAINMENU;
    }
}
