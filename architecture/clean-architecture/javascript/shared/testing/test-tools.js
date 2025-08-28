
function it(desc, fn, cleanupFn = false, options = { logErr: false, devLog: false }) {
    try {
        fn();
        console.log('\x1b[32m%s\x1b[0m', '\u2714 ' + desc);
    } catch (error) {
        console.log('\x1b[31m%s\x1b[0m', '\u2718 ' + desc);
        options.logErr && console.error(error);
    } finally {
        cleanupFn && cleanupFn();
        options.devLog && console.log(options.devLog);
    }
}

async function itAsync(desc, fn, cleanupFn = false, options = { logErr: false, devLog: false }) {
    try {
        await fn();
        console.log('\x1b[32m%s\x1b[0m', '\u2714 ' + desc);
    } catch (error) {
        console.log('\x1b[31m%s\x1b[0m', '\u2718 ' + desc);
        options.logErr && console.error(error);
    } finally {
        cleanupFn && cleanupFn();
        options.devLog && console.log(options.devLog);
    }
}

function assert(condition) {
    if (!condition) {
        throw new Error();
    }
}

export {
    it,
    itAsync,
    assert
}