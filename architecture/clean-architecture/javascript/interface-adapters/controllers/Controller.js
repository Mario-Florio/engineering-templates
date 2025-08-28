import Repository from '../repositories/Repository.js';
import Presenter from '../presenters/Presenter.js';
import Create from '../../core/use-cases/Create.js';
import Read from '../../core/use-cases/Read.js';
import ReadOne from '../../core/use-cases/ReadOne.js';
import Update from '../../core/use-cases/Update.js';
import Delete from '../../core/use-cases/Delete.js';
import DB from '../../infrastructure/db.js';

const db = new DB();
const repo = new Repository(db);
const presenter = new Presenter();

function create(paramObj) {
    const useCase = new Create(repo, presenter);
    return useCase.execute(paramObj);
}

function read(paramObj) {
    const useCase = new Read(repo, presenter);
    return useCase.execute(paramObj);
}

function readOne(paramObj) {
    const useCase = new ReadOne(repo, presenter);
    return useCase.execute(paramObj);
}

function update(paramObj) {
    const useCase = new Update(repo, presenter);
    return useCase.execute(paramObj);
}

function remove(paramObj) {
    const useCase = new Delete(repo, presenter);
    return useCase.execute(paramObj);
}

export default {
    create,
    read,
    readOne,
    update,
    remove
}