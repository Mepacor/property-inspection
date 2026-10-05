import { render, screen } from '@testing-library/react';
import { describe, expect, it } from 'vitest';
import App from './App.jsx';

describe('App', () => {
  it('shows the local workspace welcome message', () => {
    render(<App />);

    expect(screen.getByRole('heading', { name: 'Property Inspection' })).toBeTruthy();
    expect(screen.getByText('Application is running locally')).toBeTruthy();
  });
});
