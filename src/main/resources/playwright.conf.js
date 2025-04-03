// playwright.config.js
const { defineConfig } = require('@playwright/test');

module.exports = defineConfig({
    testDir: './tests', // Directory containing test files
    timeout: 30000, // Timeout for each test case in milliseconds
    reporter: 'html', // Reporter to use (e.g., 'html', 'list', 'json')
    use: {
        browserName: 'chromium', // Browser to use ('chromium', 'firefox', 'webkit')
        headless: false, // Whether to run in headless mode
        viewport: { width: 1280, height: 720 }, // Default viewport size
        screenshot: 'only-on-failure', // Screenshot options ('on', 'off', 'only-on-failure')
        video: 'off', // Video recording options ('on', 'off', 'retain-on-failure')
    },
    projects: [
        {
            name: 'Chromium',
            use: {
                browserName: 'chromium',
            },
        },
        {
            name: 'Firefox',
            use: {
                browserName: 'firefox',
            },
        },
        {
            name: 'Webkit',
            use: {
                browserName: 'webkit',
            },
        },
    ],
});