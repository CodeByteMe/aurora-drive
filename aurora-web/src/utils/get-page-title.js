import defaultSettings from '@/settings'

const title = defaultSettings.title || 'aurora-drive-web'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
