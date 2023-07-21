document.addEventListener('DOMContentLoaded', function () {
    const toggleButton = document.getElementById('toggleButton');
    const toggleTextTable = document.getElementById('toggleTextTable');
    const toggleTextKey = document.getElementById('toggleTextKey');
    const toggleTextLedger = document.getElementById('toggleTextLedger');
    const toggleTextGraph = document.getElementById('toggleTextGraph');

    toggleButton.addEventListener('click', function () {
        // Table text to toggle
        if (toggleTextTable.classList.contains('hidden-text')) {
            // If the text is hidden, show it by removing the hidden-text class
            toggleTextTable.classList.remove('hidden-text');
            toggleButton.textContent = 'Hide Informative Text';
        }
        else {
            // If the text is visible, hide it by adding the hidden-text class
            toggleTextTable.classList.add('hidden-text');
            toggleButton.textContent = 'Display Informative Text';
        }

        // Color Key text to toggle
        if (toggleTextKey.classList.contains('hidden-text')) {
            // If the text is hidden, show it by removing the hidden-text class
            toggleTextKey.classList.remove('hidden-text');
            toggleButton.textContent = 'Hide Informative Text';
        }
        else {
            // If the text is visible, hide it by adding the hidden-text class
            toggleTextKey.classList.add('hidden-text');
            toggleButton.textContent = 'Display Informative Text';
        }

        // Ledger text to toggle
        if (toggleTextLedger.classList.contains('hidden-text')) {
            // If the text is hidden, show it by removing the hidden-text class
            toggleTextLedger.classList.remove('hidden-text');
            toggleButton.textContent = 'Hide Informative Text';
        }
        else {
            // If the text is visible, hide it by adding the hidden-text class
            toggleTextLedger.classList.add('hidden-text');
            toggleButton.textContent = 'Display Informative Text';
        }

        // Graph text to toggle
        if (toggleTextGraph.classList.contains('hidden-text')) {
            // If the text is hidden, show it by removing the hidden-text class
            toggleTextGraph.classList.remove('hidden-text');
            toggleButton.textContent = 'Hide Informative Text';
        }
        else {
            // If the text is visible, hide it by adding the hidden-text class
            toggleTextGraph.classList.add('hidden-text');
            toggleButton.textContent = 'Display Informative Text';
        }
    });
});