/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ['./src/**/*.{js,jsx,ts,tsx}'],
    theme: {
        extend: {
            colors: {
                'custom-pink': '#d9b5b1',
                'main-bg': '#F9F5F2',
                'orders-div': '#F7EFEE',
                'orders-item': '#CD9F98',
                'header-bg-color': '#ebd6d2',
            },
        },
    },
    plugins: [],
}
